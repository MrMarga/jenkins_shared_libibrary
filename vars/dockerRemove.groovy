def call(String dockerHubUsername, String imageName ){
          sh "docker rmi ${dockerHubUsername}/${imageName}:latest"
          sh "docker rmi ${dockerHubUsername}/${imageName}:${BUILD_NUMBER}"
       }
