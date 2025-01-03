pipeline {
    // En que agente esto estará corriendo
    agent any
    
    options {
        timeout(time: 1, unit: 'HOURS') // timeout on while pipeline job
    }

    // Herramientas que se usarán en el pipeline
    tools{
        maven 'maven_3_9_5'
    }

    // Variables de entorno
    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'maven_3_9_5', type: 'maven'
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
    post {
        always {
            echo 'Soy un mensaje que aparece siempre'
        }

        success {
            echo 'Soy un mensaje que aparece si todo sale bien'
        }

        failure {
            echo 'Soy un mensaje que aparece si algo sale mal'
        }

        cleanup {
            echo 'Soy un mensaje que aparece al final de todo, sin importar el resultado'
        }

        regression {
            echo 'Soy un mensaje que aparece si se ejecuta la etapa de regression, es decir, el build anterior pasó y este no'
        }
    }

}