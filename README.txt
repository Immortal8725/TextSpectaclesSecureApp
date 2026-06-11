TextSpectacles Secure App (NetBeans Web Application)
====================================================

Purpose
-------
Secure JEE mini-project for Question 2 of INT316D.

Main Features
-------------
- JSP/HTML interactive views
- Personalised session greeting using “Siri”
- Session-based conversational state
- EJB business logic
- DESede encryption/decryption
- Database persistence for shared keys and messages
- Role-based security (agent, manager, admin)
- Robust handling of invalid agent IDs, unauthorized access and missing resources

Server
------
- GlassFish / Payara compatible

Database
--------
- Database name: TextSpectaclesDB
- Username: app
- Password: 123

File Realm Users to Create
--------------------------
- agent1 / 123 / agent
- agent2 / 321 / agent
- boss   / 123 / manager

Notes
-----
1. Import as a NetBeans Web Application.
2. Run the SQL script in setup/TextSpectaclesDB.sql.
3. Configure the datasource or adjust DBConnection.java if needed.
4. Create the file-realm users in the application server.
