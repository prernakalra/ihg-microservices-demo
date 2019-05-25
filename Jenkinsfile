node('master') {
    currentBuild.result="SUCCESS"
     //def server = Artifactory.server 'JFrog'
     def mvnHome
    try {
        stage ('Check-Out'){
            //slackSend color: '#4171f4', message: 'Deployment started on Pivotal Cloud Foundry '
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3a22a56c-a9fa-4ec7-885e-88085f535991', url: 'https://smetal1@bitbucket.org/ctsihg/ihg-microservices-demo']]])
        }
        //stage ('SonarQube'){
         //   withSonarQubeEnv('SonarQube'){
           //     sh 'mvn clean package -DskipTests=true sonar:sonar'
            //}
        //}

  
        
          
            
           
        }
        stage('PCF_Deployment'){
            sh 'chmod +x cf_deployment.sh'
            sh './cf_deployment.sh'
           // slackSend color: '#42f44e', message: "Deployment Successfull on Pivotal Cloud Foundry!! Details: '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})  Visit: <https://ihgdemo.app.dev.digifabricpcf.com/|IHG Dashboard>"
        }
 


       
    } catch(err){
       // slackSend color: '#e2062b', message: "Deployment Failed on Pivotal Cloud Foundry!! Details:'${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) "
        currentBuild.result = "FAILURE"
        throw err
    }
}
