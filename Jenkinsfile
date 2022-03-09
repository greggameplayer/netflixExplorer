pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-17-slim'
            reuseNode true
        }
    }
    stages {
        stage('build') {
            steps {
                sh '''
                mvn clean dependency:copy-dependencies package shade:shade
                '''
            }
        }
        stage('test') {
            steps {
                sh '''
                mvn test site
                '''
            }
        }
        stage('generate website') {
            steps {
                sh '''
                java -jar ./target/netflixExplorer*.jar ./assets/netflix_titles.csv
                '''
            }
        }
        stage('deploy') {
            steps {
                sshPublisher(
                   continueOnError: false, failOnError: true,
                   publishers: [
                    sshPublisherDesc(
                     configName: "ubuntu",
                     verbose: true,
                     transfers: [
                      sshTransfer(
                       sourceFiles: "*.html",
                       remoteDirectory: "/"
                      )
                     ])
                   ]
                )
            }
        }
        stage('Results') {
            steps {
                junit '**/target/site/surefire-report.html'
                archiveArtifacts 'target/*.jar'
            }
        }
        stage("clear") {
            steps {
                cleanWs deleteDirs: true
            }
        }
    }
}
