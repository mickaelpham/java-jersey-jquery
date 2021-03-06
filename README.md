Getting started with Jersey (JAX-RS) and jQuery
==============================================================

The purpose of this project is to manipulate the Jersey framework, an
implementation of the JAX-RS reference (RESTful Web Services). In addition
to that, the development of a light HTML+JavaScript client using AJAX will
be a good way to familiarize myself with these technologies.

Technologies Used
-----------------

* [Jersey](http://jersey.java.net/) - JAX-RS Implementation
* [jQuery](http://jquery.com/) - a new kind of JavaScript library
* [Maven](http://maven.apache.org/) - build tool
* [Jetty](http://jetty.codehaus.org/jetty/) - embedded HTTP server and servlet
container
* [Skeleton](http://www.getskeleton.com/) - a responsive CSS theme

Build and run the projet
------------------------

    $ mvn clean install jetty:run

And then, open your web browser to `http://localhost:8080/` to see the magic..
