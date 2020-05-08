$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/io/duotech/features/product_info/product_info.feature");
formatter.feature({
  "name": "Product description",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verufy product name",
  "description": "     As a user, I want to be able to login  # Description of the scenario ",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "io.duotech.step_definitions.LoginStepDefs.i_am_on_a_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Blouse\"",
  "keyword": "When "
});
formatter.match({
  "location": "io.duotech.step_definitions.ProductInfoStepDefs.i_click_on(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The product page should also display \"Blouse\"",
  "keyword": "Then "
});
formatter.match({
  "location": "io.duotech.step_definitions.ProductInfoStepDefs.the_product_page_should_also_display(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The product price should be 27.0",
  "keyword": "And "
});
formatter.match({
  "location": "io.duotech.step_definitions.ProductInfoStepDefs.the_product_price_should_be(java.lang.Double)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});