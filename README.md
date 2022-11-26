# Java implementation of DIAL server

## HOW TO USE
Before you start the application, make sure to have the right ip configured (you have to insert your computer ip directly in the code)
Just start the dial and cast player applications.

Any m-search message recevied by the dial application will receive an m-search response with the local ip and url for the detail application.

## TODO
- Migrate ip of the machine to configuration or make it dynamic
- Create a database with all applications and their status
- Find a way to start/stop external applications (maybe Chrome)

## FEATURES
- Dial server to send m-search response
- Api to send device informations (mock)
- Api to send youtube application status (mock)
- TODO: Post api for youtube application
- TODO: Start/stop youtube application

#### DIAL DOCUMENTATION
- http://www.dial-multiscreen.org/dial-protocol-specification
- https://docs.google.com/viewer?a=v&pid=sites&srcid=ZGlhbC1tdWx0aXNjcmVlbi5vcmd8ZGlhbHxneDo1MWVmNzNhZDUyYTI0YTkz