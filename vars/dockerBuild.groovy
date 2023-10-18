def call(String dockerHubUsername, String imageName ) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=b7d0e51456mshf4b33a94aebf47dp139c37jsn74e7d26e47fe -t ${dockerHubUsername}/${imageName} ."
     // Tag the Docker image
    sh "docker tag ${dockerHubUsername}/${imageName} ${dockerHubUsername}/${imageName}:latest"
    sh "docker tag ${dockerHubUsername}/${imageName} ${dockerHubUsername}/${imageName}:${BUILD_NUMBER}"
    // Push the Docker image
    withDockerRegistry(credentialsId: 'docker-cred') {
    sh "docker push ${dockerHubUsername}/${imageName}:latest"   
    sh "docker push ${dockerHubUsername}/${imageName}:${BUILD_NUMBER}"
    }
    
}
