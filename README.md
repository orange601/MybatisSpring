# MybatisSpring
MybatisSpring 연동하기

# 1. web.xml 설정
````xml
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath*:config/context-*.xml</param-value>
	</context-param>
	
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<servlet>
		<servlet-name>mbServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/framework/*.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>mbServlet</servlet-name>
		<url-pattern>/</url-pattern>	
	</servlet-mapping>
````
# 2. servlet-context.xml설정
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans 
    xmlns="http://www.springframework.org/schema/beans"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd"
        >
	<context:component-scan base-package="com.mybatis" />

</beans>
````

# 3. Sqlsession 설정
````xml
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
<!-- 		<property name="configLocation" value="classpath:/sqlmap/config/sql-mapper-config.xml" /> -->
		<property name="mapperLocations" value="classpath:/com/mybatis/**/mapper/*Mapper.xml" />
	</bean>
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  		<constructor-arg index="0" ref="sqlSessionFactory" />
	</bean>
````

# 4. datasource 설정
````xml
	<bean id="propertyConfigurer"
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:/props/jdbc.properties</value>
			</list>
		</property>
	</bean>

	<alias name="dataSource-${jdbc.dbType}" alias="dataSource" />

	<!-- MySQL -->
	<bean id="dataSource-mysql" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close">
		<property name="driverClassName" value="${jdbc.driverClass}" />
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.userId}" />
		<property name="password" value="${jdbc.userPwd}" />
	</bean>
````

