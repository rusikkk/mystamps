*** Settings ***
Documentation   Verify account activation validation scenarios
Library         Selenium2Library
Suite Setup     Before Test Suite
Suite Teardown  After Test Suite
Force Tags      account  activation  validation

*** Test Cases ***
Activate account with matching login and password
	Input Text              id=login            admin
	Input Text              id=password         admin
	Submit Form             id=activate-account-form
	Element Text Should Be  id=password.errors  Password and login must be different

*** Keywords ***
Before Test Suite
	Open Browser                        ${SITE_URL}  ${BROWSER}
	Register Keyword To Run On Failure  Log Source
	Go To                               ${SITE_URL}/account/activate

After Test Suite
	Close Browser
