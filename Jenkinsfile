pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Fabric') {
      steps {
        sh 'mvn fabric8:build'
      }
    }
  }
}