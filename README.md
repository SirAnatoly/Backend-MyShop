# This is my project: online shop with admin board.On Java EE technology

<a href="https://youtu.be/7zCUDVQZyO8">VIDEO DEMO:</a>

 
[![Watch the video](http://i.piccy.info/i9/5fd4a906ff7ed35bce63e9472924469e/1604354613/168608/1403575/foto2.jpg)](https://youtu.be/7zCUDVQZyO8)


<a href="http://piccy.info/view3/14051832/4f0fc51d8e891de6d4cfcc602e8d68bd/1200/" target="_blank"><img src="http://i.piccy.info/i9/9e05fdd39c5f77cdde648a4e8068f3c1/1604352942/53331/1403575/web_app_my_shop_png_800.jpg" alt="Piccy.info - Free Image Hosting" border="0" /></a><a href="http://i.piccy.info/a3c/2020-11-02-21-35/i9-14051832/800x416-r" target="_blank"><img src="http://i.piccy.info/a3/2020-11-02-21-35/i9-14051832/800x416-r/i.gif" alt="" border="0" /></a>

<a href="http://piccy.info/view3/14051830/737e6eb4e9a51d07156fddb335c61d5d/orig/" target="_blank"><img src="http://i.piccy.info/i9/43e37da39edfa7122a4264a36a0f1836/1604352839/83670/1403575/1_800.jpg" alt="Piccy.info - Free Image Hosting" border="0" /></a><a href="http://i.piccy.info/a3c/2020-11-02-21-34/i9-14051830/800x444-r" target="_blank"><img src="http://i.piccy.info/a3/2020-11-02-21-34/i9-14051830/800x444-r/i.gif" alt="" border="0" /></a>


<h3>Technologies </h3>
  <ul>
<li>Interface : HTML/CSS/JS/Bootstrap/jQuery.</li>
<li>JavaEE: Servlets, JSP, JSTL.</li>
<li>Hibernate</li>
<li>JSON</li>
<li>Apache Commons : email, validator.</li>
<li>Database: MySql.</li>
<li>Libraries: RestFacebook, Lombok.</li>
<li>Maven, Logback.</li>
  </ul>

# I have implemented the following features:

  <ul>
    <li>Displaying of all products in the shop, button(more products) via AJAX loading </li>
    <li>Button return to the top</li>
    <li>Category panel with a quantity indicator</li> 
    <li>Searching products by: name, using categories or producers from the filters tab (via SQL) </li> 
    <li> Tab - More filters, contains categories and producers with a quantity indicator</li>
    <li>Button for registering in the shop by Facebook</li>
    <li>The shopping cart tab with indicators of a quantity of products and total cost.</li>
    <li>When you click a buy button, will be an open popup with an indicator of the number of products and their total cost, the maximum number of products is 10 pieces.</li>
    <li>An unregistered user can't create an order, but he can add products to the shopping cart or delete.
</li>
    <li>If the user successfully login to the shop, he will be forwarded to a page(my orders) with a table of his orders, and short information in the navigation panel.
</li>
    <li> If the user has selected the required number of products, he can create an order, after which he will receive a notification about the successful order.
</li>
    <li> After successful creating order, the server will send the email to the administrator's email address, with the information about the user like ( name, email, orders short description)
</li>
    <li>Also, the Buyer will also receive an email with information about the order and thanks for the purchase.
</li>
    <li>The Admin Board page is shop management page, where can only be accessed by Admin email.</li>
    <li>If you access the site as a non-Admin email, the user will be redirected to a page with an error (access denied)
</li>
    <li>If the user login into the shop from the administrator's email address, the Admin Board button appears in the navbar menu
</li>
    <li>The admin panel has 3 tabs (Dashboard, Messages, Add product)
</li>
    <li>The dashboard has 3 indicators, the number of products in the store, the number of registered users, and the approximate revenue of the shop.
</li>
    <li>Also in the dashboard is a table with all the products, with a description of each and a button to delete the product. When you click delete, the product is deleted, and a notification appears the product which was successfully deleted.
</li>
    <li>You can sort by product attribute or set the number of displayed products in the table also you can search by name (via JS).
</li>
    <li>The Messages page has a large table with all orders in the shop and a description of each
</li>
    <li>On the Add product page has a form for adding a new product to the shop, after filling all the values, will be displayed a message about the successful addition of a product to the shop.
</li>
    <li>When you click Log out, the session with the user ends and the user becomes a guest.
</li>

  </ul>

<h2>Base Blog Props</h2>
 <h3>1) File: src/main/resources/application.properties</h3>
 
 
application.production=true<br>
social.facebook.idClient=328479825126601<br>
social.facebook.secret=2580fb7fd745a451b05e43bacc074753<br>
app.host=https://localhost:8443<br>
email.notificationEmail=XXXXX@gmail.com<br>
email.sendTryCount=2<br>
email.smtp.server=smtp.gmail.com<br>
email.smtp.port=465<br>
email.fromEmail=XXXXX@gmail.com<br>
email.smtp.username=XXXXX@gmail.com<br>
email.smtp.password=XXXXX<br>


<h3>2) File: src/main/java/MyShop/Constants.java</h3>

public class Constants {

	public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";

	public static final int MAX_PRODUCTS_PER_SHOPPING_CART = 20;
	
	public static final String ACCOUNT_ACTIONS_HISTORY = "ACCOUNT_ACTIONS_HISTORY";

	public static final int MAX_PRODUCTS_PER_HTML_PAGE = 12;

	public static final String CATEGORY_LIST = "CATEGORY_LIST";

	public static final String PRODUCER_LIST = "PRODUCER_LIST";

	public static final String CURRENT_ACCOUNT = "CURRENT_ACCOUNT";

}
<h3>3) File: src/main/resources/hibernate.cfg.xml</h3>

    <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="connection.url">jdbc:mysql://localhost:3306/MyShop?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=CONVERT_TO_NULL&amp;serverTimezone=UTC&amp;useSSL=false</property>
    <property name="connection.username">XXXXX</property>
    <property name="connection.password">XXXXX</property>
    <property name="hibernate.connection.characterEncoding">utf8</property>
    <property name="hibernate.format_sql">true</property>
    <property name="hibernate.current_session_context_class">thread</property>



