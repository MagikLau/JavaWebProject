# JavaWebProject
Netease course JavaWeb Project<br/>
## Java Web开发实践<br/>
针对已给出的需求、数据库和前端代码，进行了一定修改，去除了ftl模板中买家关于数量的显示<br/>
演示地址已过期，暂不开放<br/>

### 开发工具：
IntelliJ IDEA 2017
  
### 工程管理：
使用Maven进行工程及jar包的管理，Archetype选择：maven-archetype-webapp<br/>
#### 工程结构：
![Idea工程结构截图](https://github.com/LauItachi/JavaWebProject/blob/master/pic01.png)

### 代码管理：
GitHub，并使用idea中集成的GitHub插件进行push和pull操作。

### 框架结构及实现
使用SpringMVC框架进行系统搭建。<br/>
<b>View层实现</b>：使用FreeMarker模板技术，在spring-mvc配置文件中配置Freemarker的相关配置，使用ftl模板文件进行html的生成，完成View层的展示；<br/>
<b>Web-Controller层</b>：主要完成基础数据的呈现和请求的转发及重定向；<br/>
<b>Web-Controller-Api层</b>：主要完成对异步数据的处理, 使用ModelMap、ModelAndView进行对象模型的处理，实现将下层的数据对象转达到view层；<br/>
<b>Service层实现</b>：使用Spring进行Dao的依赖注入，完成Service层普通CRUD业务及交叉业务的处理；<br/>
<b>Dao层</b>：Java代码只提供Dao接口，具体实现由Mybatis的对应mapper来完成数据库操作<br/>
<b>Model层</b>：主要存放JavaBean实体类。<br/>


<br/>

