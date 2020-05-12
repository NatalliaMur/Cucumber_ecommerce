node ('Linux') {
  
   stage('Checkout') {
       git 'https://github.com/NatalliaMur/Cucumber_ecommerce'
   }
   
   try{
   stage('Build and Test') {
    bat label: '', script: 'mvn verify -Dcucumber.filter.tags="@test1"' 
   }
   }catch(Exception e){
       echo "Build failed"
   }
   stage('Report') {
    cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1  
    junit '**/*Cucumber.xml'
       
   }
    stage('Email') {
    step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'natalliamurashka984@gmail.com', sendToIndividuals: false])
       
   }
   
}
