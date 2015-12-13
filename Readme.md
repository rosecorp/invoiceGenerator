Command line Scala app to generate invoices in pdf

The example of the json structures are under resources.
 - payee.json
 - payer.json
 - pdf-details.properties // prefix, suffix for the pdf name and the location where the pdf will be created.
 
Resources will be loaded from the location specified in the config.properties file.
If no config is found there the pdf will be generated using the default files under resources.

The data for the invoice is coming from:

 - payee.json: person been paid
 
 - payer.json: basic information from the company being given the invoice
 
 - pdf-details.properties: contains the the naming of the pdf that will be generated
 
 - days worked: first argument from the command line execution
 
 - invoice number: second argument entered.

 
 To generate a jar run: 
 > sbt assembly 

 To execute the app (ej:for 21 days worked and invoice number: 24) run: 
 > java -jar invoicer.jar 21 24
 
 A pdf will be generated in the folder where the jar is.
 
