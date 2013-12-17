INSERT INTO category (name, description) VALUES ('Category One', 'Category one description');

INSERT INTO category (name, description) VALUES ('Category Two', 'Category two  description');

INSERT INTO category (name, description) VALUES ('Category Three', 'Category three description');

INSERT INTO category (name, description) VALUES ('Category Four', 'Category four description');

INSERT INTO product VALUES ('L001', 'Product1', 20, 12, 16, 'JavaServer Faces (JSF) technology is a new user interface framework for J2EE applications. It is particularly suited, by design, for use with applications based on the MVC architecture. Numerous articles have been published to introduce JSF. However, most of them take a highly theoretical approach that does not meet the challenges of real-world enterprise development. There are still a lot of issues that need to be solved. For example, how JSF fits INTO the overall MVC architecture? How JSF integrates with other Java frameworks? Should business logic exist in the JSF backing beans? How to handle security in JSF? And most importantly, how to build a real-world web application using JSF? This article addresses all these issues. It shows you how to integrate JSF with other Java frameworks – specifically, Spring Framework and Hibernate.');

INSERT INTO product VALUES ('L002', 'Product2', 40, 18, 16, 'The sample application used in this article is an online product catalog system. By showing you how to build a real-world web application, this article covers each phase of the web application design, including business requirement gathering, analysis, technology selection, high-level architecture and implementation level design. It discusses the advantages and disadvantages of the technologies used in the sample application. It also demonstrates the approach to designing some key aspects of the sample application.This article is aimed at Java architects, developers already working with J2EE based web application. It is not an introduction to JSF, Spring Framework and Hibernate.');

INSERT INTO product VALUES ('L003', 'Product3', 38.88, 20, 18, 'The sample application is a real-world web application, which is realistic enough to provide the basis for a meaningful discussion of web application architectural decisions. It is important to begin by presenting the requirements of the sample application. I will refer back to this section throughout the rest of the article to address the technical decisions and architecture design. The first phase in designing a web application is to gather functional requirements for the system. The sample application is a typical e-business application system.');

INSERT INTO product VALUES ('L004', 'Product4', 22.99, 18, 14, 'There are two groups of pages in the sample application – public internet and administration intranet. The intranet is only accessible to the users who log in the system successfully. ProductSummary is not presented to the users as a separate page. It is shown inside a HTML frame within the Catalog page. ProductList is a special catalog viewable only by the administrators. It contains links to create product, edit product and delete product.');

INSERT INTO product VALUES ('L005', 'Product5', 18.68, 17, 21, 'A multi-tier architecture partitions the whole system INTO distinct functional units - client, presentation, business logic, integration and enterprise information system (EIS). This ensures a clean division of responsibility and makes the system more maintainable and extensible. Systems with three or more tiers have proven more scalable and flexible than a client-server system, in which there is no business logic middle tier.');

INSERT INTO product VALUES ('L006', 'Product6', 28.99, 19, 20, 'The business logic tier contains the business objects and the business services of an application. It receives requests from the presentation tier, processes the business logic based on the requests and mediates access to EIS tier resources. Business logic tier components benefit most from system level services such as security management, transaction management and resource management.');

INSERT INTO product VALUES ('L007', 'Product7', 36.66, 16, 18, 'A multi-tier non-distributed architecture is used for the sample application. The diagram shows us the partitioning of the application tiers, and the technologies chosen for each tier. It also serves as a deployment diagram of the sample application. For a collocated architecture, the presentation tier, business logic tier and integration tier are located in the same web container physically. Well-defined interfaces are used to isolate the responsibility for each tier. The collocated architecture makes the application simple and scalable.');

INSERT INTO product VALUES ('L008', 'Product8', 32.99, 26, 18, 'Model-View-Controller (MVC) is the Java BluePrints recommended architectural design pattern for interactive application. MVC separates design concerns, decreasing code duplication, centralizing control, and making the application more extensible. MVC also helps developers with different skill sets to focus on their core skills and collaborate through clearly defined interfaces. MVC is the architectural design pattern for the presentation tier.');

INSERT INTO product_category VALUES('L001', 1);

INSERT INTO product_category VALUES('L001', 2);

INSERT INTO product_category VALUES('L001', 3);

INSERT INTO product_category VALUES('L001', 4);

INSERT INTO product_category VALUES('L002', 1);

INSERT INTO product_category VALUES('L002', 3);

INSERT INTO product_category VALUES('L003', 1);

INSERT INTO product_category VALUES('L003', 4);

INSERT INTO product_category VALUES('L004', 1);

INSERT INTO product_category VALUES('L004', 2);

INSERT INTO product_category VALUES('L005', 1);

INSERT INTO product_category VALUES('L005', 4);

INSERT INTO product_category VALUES('L006', 1);

INSERT INTO product_category VALUES('L006', 2);

INSERT INTO product_category VALUES('L007', 1);

INSERT INTO product_category VALUES('L007', 3);

INSERT INTO product_category VALUES('L008', 1);

INSERT INTO product_category VALUES('L008', 2);

INSERT INTO product_category VALUES('L008', 4);

INSERT INTO user VALUES('admin', 'admin');

COMMIT;