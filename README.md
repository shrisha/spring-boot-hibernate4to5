# Sample app that demonstrates problems upgrading from Hibernate 4 to 5
By default, the pom.xml sets you up with spring-boot 1.3.5
## Hibernate 4
* Create schema `h4to5` in MySQL. Verify permissions for `app/app` u/p. Alternatively, modify creds in `application.yml`
* Run Application with `spring.active.profiles=default,h4`
* note generate schema
```-- Create syntax for TABLE 'User'
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `camelCaseCol` varchar(255) DEFAULT NULL,
  `col1` varchar(255) DEFAULT NULL,
  `col2` varchar(255) DEFAULT NULL,
  `col3` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_User_username` (`username`),
  UNIQUE KEY `UK_User_col1_col2` (`col1`,`col2`),
  KEY `IDX_col3` (`col3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'Tweet'
CREATE TABLE `Tweet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oh8mf7r69jsk6iisptiaocc6l` (`user_id`),
  CONSTRAINT `FK_oh8mf7r69jsk6iisptiaocc6l` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

```
## Hibernate 5

* modify `pom.xml` to pull in spring-boot 1.5.2 by commenting out line 17 & uncommenting line 18
* Run Application with `spring.active.profiles=default,h5`
* Note DDL statement generted even though a FK `FK_oh8mf7r69jsk6iisptiaocc6l` already exists

```alter table Tweet add constraint FKtjo83phj1ffkewrkbxqmfvw36 foreign key (user_id) references User (id)```

The [issue against Hibernate](https://hibernate.atlassian.net/browse/HHH-10574) appears to have stalled.

Our DB that houses 100s of tables with many tables containing 100s of millions of rows, re-creating foreign keys (technically, Hibernate is creating duplicate keys) is simply not an option.



