*** Settings ***
Documentation    Verify required elements appearance on the main page from a user
Library          Selenium2Library
Resource         ../auth.steps.robot
Suite Setup      Before Test Suite
Suite Teardown   After Test Suite
Force Tags       misc  main-page

*** Test Cases ***
User should not see a link to a page for importing a series
	[Tags]                        import-series
	Page Should Not Contain Link  link=import a series

User should not see a link to a list of import requests
	[Tags]                        import-series
	Page Should Not Contain Link  link=show list of import requests

*** Keywords ***
Before Test Suite
	Open Browser                        ${SITE_URL}  ${BROWSER}
	Register Keyword To Run On Failure  Log Source
	Log In As                           login=coder  password=test
	Go To                               ${SITE_URL}/

After Test Suite
	Log Out
	Close Browser
