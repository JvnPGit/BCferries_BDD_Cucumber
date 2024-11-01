$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/LoginPage.feature");
formatter.feature({
  "name": "LoginPage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Open browser and close",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@scenario0"
    }
  ]
});
formatter.step({
  "name": "User launched browser",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User closed the browser",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
});