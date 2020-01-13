pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
        sh 'mvn clean package'
      }
    }
    stage('Fabric - Build') {
      steps {
        sh 'mvn fabric8:build'
      }
    }
    stage('Fabric Deploy') {
      steps {
        sh 'mvn fabric8:deploy'
      }
    }
    stage('To QA') {
      steps {
        sh 'oc tag myproject:order:latest myproject:order:QA'
      }
    }
  }
}