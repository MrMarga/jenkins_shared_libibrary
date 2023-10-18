def call() {
    sh 'trivy image mrmarga/youtube:latest > trivyimage.txt'
}
 