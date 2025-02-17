
 Feature: Validating Place API's

   Scenario: Verify if Place is being Successfully added using AddPlaceAPI
     Given Add Place  Payload
     When user make "post" call to "AddPlace" api
     Then user gets the success response with status code 200
     And validate response body field "status" should be "OK"
     And validate response body field "scope" should be "APP"