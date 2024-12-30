pipeline {
    agent any

    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'maven_3_9_5', type: 'maven'
                    echo 'Maven Home: ${Nombre}'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh 'mvn -version'
                        sh 'mvn compile'
                    }
                }

            }
        }

        stage('Test Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'maven_3_9_5', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh "mvn test"
                    }
                }
            }

        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }

    }

}