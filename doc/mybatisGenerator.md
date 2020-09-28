# 使用mybatisGenerator生成模板代码

## generator配置文件设置
generator配置文件设置如下代码所示，需要设置的配置项包含：javaModelGenerator、sqlMapGenerator、javaClientGenerator

javaModelGenerator配置java实体类的路径  
sqlMapGenerator配置生成对应的映射文件路径  
javaClientGenerator配置Dao类存放位置，Dao文件是对数据表的常用操作  
table配置需要查询的表名称
```aidl
<generatorConfiguration>
    <context id="my" targetRuntime="MyBatis3">

        <!--自动实现Serializable接口-->
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"></plugin>

        <!-- 去除自动生成的注释 -->
        <commentGenerator>
            <property name="suppressAllComments" value="true" />
        </commentGenerator>

        <!--数据库基本信息-->
        <jdbcConnection driverClass="org.postgresql.Driver"
                        connectionURL="jdbc:postgresql://10.110.25.75:50704/testservice?characterEncoding=utf8"
                        userId="postgres"
                        password="5t3aV9XOs2">
        </jdbcConnection>

        <!--生成实体类的位置以及包的名字-->
        <!--同样Mac用户：targetProject 为全路径-->
        <javaModelGenerator targetPackage="com.inspur.testservice.demo.domain" targetProject="src/main/java">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="true" />
            <!-- 从数据库返回的值被清理前后的空格 -->
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <!--生成映射文件存放位置-->
        <!--同样Mac用户：targetProject 为全路径-->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>

        <!--生成Dao类存放位置,mapper接口生成的位置-->
        <!--同样Mac用户：targetProject 为全路径-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.inspur.testservice.demo.dao" targetProject="src/main/java">
            <!-- enableSubPackages:是否让schema作为包的后缀 -->
            <property name="enableSubPackages" value="false"/>
        </javaClientGenerator>

        <!-- 配置表信息 -->
        <!-- schema即为数据库名 tableName为对应的数据库表 domainObjectName是要生成的实体类 enable*ByExample
            是否生成 example类 -->
        <table tableName="book"
               domainObjectName="Book" enableCountByExample="false"
               enableDeleteByExample="false" enableSelectByExample="false"
               enableUpdateByExample="false">
        </table>

    </context>
</generatorConfiguration>
```