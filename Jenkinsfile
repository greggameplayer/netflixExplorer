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
                mvn clean dependency:copy-dependencies package shade:shade -DskipTests
                '''
            }
        }
        stage('test') {
            steps {
                sh '''
                mvn test surefire-report:report
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
                     ]),
                     sshPublisherDesc(
                      configName: "nicolas_server",
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
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My SonarQube Server') {
                sh "mvn verify sonar:sonar"
                }
            }
        }
    }

    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
            step( [ $class: 'JacocoPublisher' ] )
        }
        cleanup {
            cleanWs deleteDirs: true
        }
    }
}
