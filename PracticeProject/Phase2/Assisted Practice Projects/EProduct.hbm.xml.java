<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC
"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="com.ecommerce">
    <class name="EProduct" table="eproduct">
        <id name="ID" type="long" column="ID">
            <generator class="identity"/>
        </id>
        <property name="name" type="string" column="NAME"/>
        <property name="price" type="big_decimal" column="PRICE"/>
        <property name="dateAdded" type="timestamp" column="DATE_ADDED"/>

                <list name="colors" cascade="all">
                        <key column="product_id" />
                        <list-index column="idx" />
                        <one-to-many class="com.ecommerce.Color" />
                </list>
                
                <bag name="screensizes" cascade="all">  
                <key column="product_id"></key>  
                 <one-to-many class="com.ecommerce.ScreenSizes"/>
                </bag>  
                
                <set name = "os" cascade="all">
         <key column = "product_id"/>
         <one-to-many class="OS"/>
      </set>
      
      <map name = "finance" cascade="all">
         <key column = "product_id"/>
         <index column = "ftype" type = "string"/>
         <one-to-many class="com.ecommerce.Finance"/>
      </map>
    </class>
</hibernate-mapping>
