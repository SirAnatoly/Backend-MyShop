package MyShop.service.impl;


import MyShop.model.OrderItems;
import MyShop.service.NotificationService;
import org.apache.commons.mail.*;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncEmailNotificationService implements NotificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncEmailNotificationService.class);
    private final ServiceManager serviceManager;
    private final ExecutorService executorService;
    private final int tryCount;

    AsyncEmailNotificationService(ServiceManager serviceManager) {
        super();
        this.serviceManager = serviceManager;
        this.executorService = Executors.newCachedThreadPool();
        this.tryCount = Integer.parseInt(serviceManager.getApplicationProperty("email.sendTryCount"));
    }

    @Override
    public void sendNotification(String title, String content, OrderItems orderItems,String addTo) {
        executorService.submit(new EmailItem(title, content, tryCount, orderItems,addTo));
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }


    private class EmailItem  implements Runnable {
        private final String subject;
        private final String content;
        private int tryCount;
        private OrderItems orderItems;
        String addTo;

        private EmailItem(String subject, String content, int tryCount, OrderItems orderItems, String addTo) {
            super();
            this.subject = subject;
            this.content = content;
            this.tryCount = tryCount;
            this.orderItems = orderItems;
            this.addTo = addTo;
        }

        private boolean isValidTryCount() {
            return tryCount > 0;
        }

        @Override
        public void run() {
            try {
                ImageHtmlEmail email = new ImageHtmlEmail();
                StringBuilder str = new StringBuilder();

                String htmlEmailTemplate ="  <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width\" />\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                        "    <title>MyShop</title>\n" +
                        "    <link rel=\"stylesheet\" type=\"text/css\" href=\"email.css\" />\n" +
                        "<style>\n" +
                        "* { \n" +
                        "\tmargin:0;\n" +
                        "\tpadding:0;\n" +
                        "}\n" +
                        "* { font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; }\n" +
                        "\n" +
                        "img { \n" +
                        "\tmax-width: 100%; \n" +
                        "}\n" +
                        ".collapse {\n" +
                        "\tmargin:0;\n" +
                        "\tpadding:0;\n" +
                        "}\n" +
                        "body {\n" +
                        "\t-webkit-font-smoothing:antialiased; \n" +
                        "\t-webkit-text-size-adjust:none; \n" +
                        "\twidth: 100%!important; \n" +
                        "\theight: 100%;\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tELEMENTS \n" +
                        "------------------------------------- */\n" +
                        "a { color: #2BA6CB;}\n" +
                        "\n" +
                        ".btn {\n" +
                        "\ttext-decoration:none;\n" +
                        "\tcolor: #FFF;\n" +
                        "\tbackground-color: #666;\n" +
                        "\tpadding:10px 16px;\n" +
                        "\tfont-weight:bold;\n" +
                        "\tmargin-right:10px;\n" +
                        "\ttext-align:center;\n" +
                        "\tcursor:pointer;\n" +
                        "\tdisplay: inline-block;\n" +
                        "}\n" +
                        "\n" +
                        "p.callout {\n" +
                        "\tpadding:15px;\n" +
                        "\tbackground-color:#ECF8FF;\n" +
                        "\tmargin-bottom: 15px;\n" +
                        "}\n" +
                        ".callout a {\n" +
                        "\tfont-weight:bold;\n" +
                        "\tcolor: #2BA6CB;\n" +
                        "}\n" +
                        "\n" +
                        "table.social {\n" +
                        "/* \tpadding:15px; */\n" +
                        "\tbackground-color: #ebebeb;\n" +
                        "\t\n" +
                        "}\n" +
                        ".social .soc-btn {\n" +
                        "\tpadding: 3px 7px;\n" +
                        "\tfont-size:12px;\n" +
                        "\tmargin-bottom:10px;\n" +
                        "\ttext-decoration:none;\n" +
                        "\tcolor: #FFF;font-weight:bold;\n" +
                        "\tdisplay:block;\n" +
                        "\ttext-align:center;\n" +
                        "}\n" +
                        "a.fb { background-color: #3B5998!important; }\n" +
                        "a.tw { background-color: #1daced!important; }\n" +
                        "a.gp { background-color: #DB4A39!important; }\n" +
                        "a.ms { background-color: #000!important; }\n" +
                        "\n" +
                        ".sidebar .soc-btn { \n" +
                        "\tdisplay:block;\n" +
                        "\twidth:100%;\n" +
                        "}\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tHEADER \n" +
                        "------------------------------------- */\n" +
                        "table.head-wrap { width: 100%;}\n" +
                        "\n" +
                        ".header.container table td.logo { padding: 15px; }\n" +
                        ".header.container table td.label { padding: 15px; padding-left:0px;}\n" +
                        "\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tBODY \n" +
                        "------------------------------------- */\n" +
                        "table.body-wrap { width: 100%;}\n" +
                        "\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tFOOTER \n" +
                        "------------------------------------- */\n" +
                        "table.footer-wrap { width: 100%;\tclear:both!important;\n" +
                        "}\n" +
                        ".footer-wrap .container td.content  p { border-top: 1px solid rgb(215,215,215); padding-top:15px;}\n" +
                        ".footer-wrap .container td.content p {\n" +
                        "\tfont-size:10px;\n" +
                        "\tfont-weight: bold;\n" +
                        "\t\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tTYPOGRAPHY \n" +
                        "------------------------------------- */\n" +
                        "h1,h2,h3,h4,h5,h6 {\n" +
                        "font-family: \"HelveticaNeue-Light\", \"Helvetica Neue Light\", \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif; line-height: 1.1; margin-bottom:15px; color:#000;\n" +
                        "}\n" +
                        "h1 small, h2 small, h3 small, h4 small, h5 small, h6 small { font-size: 60%; color: #6f6f6f; line-height: 0; text-transform: none; }\n" +
                        "\n" +
                        "h1 { font-weight:200; font-size: 44px;}\n" +
                        "h2 { font-weight:200; font-size: 37px;}\n" +
                        "h3 { font-weight:500; font-size: 27px;}\n" +
                        "h4 { font-weight:500; font-size: 23px;}\n" +
                        "h5 { font-weight:900; font-size: 17px;}\n" +
                        "h6 { font-weight:900; font-size: 14px; text-transform: uppercase; color:#444;}\n" +
                        "\n" +
                        ".collapse { margin:0!important;}\n" +
                        "\n" +
                        "p, ul { \n" +
                        "\tmargin-bottom: 10px; \n" +
                        "\tfont-weight: normal; \n" +
                        "\tfont-size:14px; \n" +
                        "\tline-height:1.6;\n" +
                        "}\n" +
                        "p.lead { font-size:17px; }\n" +
                        "p.last { margin-bottom:0px;}\n" +
                        "\n" +
                        "ul li {\n" +
                        "\tmargin-left:5px;\n" +
                        "\tlist-style-position: inside;\n" +
                        "}\n" +
                        "\n" +
                        "/* ------------------------------------- \n" +
                        "\t\tSIDEBAR \n" +
                        "------------------------------------- */\n" +
                        "ul.sidebar {\n" +
                        "\tbackground:#ebebeb;\n" +
                        "\tdisplay:block;\n" +
                        "\tlist-style-type: none;\n" +
                        "}\n" +
                        "ul.sidebar li { display: block; margin:0;}\n" +
                        "ul.sidebar li a {\n" +
                        "\ttext-decoration:none;\n" +
                        "\tcolor: #666;\n" +
                        "\tpadding:10px 16px;\n" +
                        "/* \tfont-weight:bold; */\n" +
                        "\tmargin-right:10px;\n" +
                        "/* \ttext-align:center; */\n" +
                        "\tcursor:pointer;\n" +
                        "\tborder-bottom: 1px solid #777777;\n" +
                        "\tborder-top: 1px solid #FFFFFF;\n" +
                        "\tdisplay:block;\n" +
                        "\tmargin:0;\n" +
                        "}\n" +
                        "ul.sidebar li a.last { border-bottom-width:0px;}\n" +
                        "ul.sidebar li a h1,ul.sidebar li a h2,ul.sidebar li a h3,ul.sidebar li a h4,ul.sidebar li a h5,ul.sidebar li a h6,ul.sidebar li a p { margin-bottom:0!important;}\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "/* --------------------------------------------------- \n" +
                        "\t\tRESPONSIVENESS\n" +
                        "\t\tNuke it from orbit. It's the only way to be sure. \n" +
                        "------------------------------------------------------ */\n" +
                        "\n" +
                        "/* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
                        ".container {\n" +
                        "\tdisplay:block!important;\n" +
                        "\tmax-width:600px!important;\n" +
                        "\tmargin:0 auto!important; /* makes it centered */\n" +
                        "\tclear:both!important;\n" +
                        "}\n" +
                        "\n" +
                        "/* This should also be a block element, so that it will fill 100% of the .container */\n" +
                        ".content {\n" +
                        "\tpadding:15px;\n" +
                        "\tmax-width:600px;\n" +
                        "\tmargin:0 auto;\n" +
                        "\tdisplay:block; \n" +
                        "}\n" +
                        "\n" +
                        "/* Let's make sure tables in the content area are 100% wide */\n" +
                        ".content table { width: 100%; }\n" +
                        "\n" +
                        "\n" +
                        "/* Odds and ends */\n" +
                        ".column {\n" +
                        "\twidth: 300px;\n" +
                        "\tfloat:left;\n" +
                        "}\n" +
                        ".column tr td { padding: 15px; }\n" +
                        ".column-wrap { \n" +
                        "\tpadding:0!important; \n" +
                        "\tmargin:0 auto; \n" +
                        "\tmax-width:600px!important;\n" +
                        "}\n" +
                        ".column table { width:100%;}\n" +
                        ".social .column {\n" +
                        "\twidth: 280px;\n" +
                        "\tmin-width: 279px;\n" +
                        "\tfloat:left;\n" +
                        "}\n" +
                        "\n" +
                        "/* Be sure to place a .clear element after each set of columns, just to be safe */\n" +
                        ".clear { display: block; clear: both; }\n" +
                        "\n" +
                        "\n" +
                        "/* ------------------------------------------- \n" +
                        "\t\tPHONE\n" +
                        "\t\tFor clients that support media queries.\n" +
                        "\t\tNothing fancy. \n" +
                        "-------------------------------------------- */\n" +
                        "@media only screen and (max-width: 600px) {\n" +
                        "\t\n" +
                        "\ta[class=\"btn\"] { display:block!important; margin-bottom:10px!important; background-image:none!important; margin-right:0!important;}\n" +
                        "\n" +
                        "\tdiv[class=\"column\"] { width: auto!important; float:none!important;}\n" +
                        "\t\n" +
                        "\ttable.social div[class=\"column\"] {\n" +
                        "\t\twidth:auto!important;\n" +
                        "\t}\n" +
                        "\n" +
                        "}\n" +
                        "</style>"+
                        "</head>\n" +
                        "<body bgcolor=\"#FFFFFF\">\n" +
                        "<table class=\"head-wrap\" bgcolor=\"#999999\">\n" +
                        "    <tr>\n" +
                        "        <td></td>\n" +
                        "        <td class=\"header container\">\n" +
                        "            <div class=\"content\">\n" +
                        "                <table bgcolor=\"#999999\">\n" +
                        "                    <tr>\n" +
                        "                        <td><h2>MyShop</h2></td>\n" +
                        "                    </tr>\n" +
                        "                </table>\n" +
                        "            </div>\n" +
                        "        </td>\n" +
                        "        <td></td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "<table class=\"body-wrap\">\n" +
                        "    <tr>\n" +
                        "        <td></td>\n" +
                        "        <td class=\"container\" bgcolor=\"#FFFFFF\">\n" +
                        "            <div class=\"content\">\n" +
                        "                <table>\n" +
                        "                    <tr>\n" +
                        "                        <td>\n" +
                        "                            <h4>" +
                        content +
                        "</h4>\n" +
                        "                            <p class=\"lead\"> </p>\n" +
                        "                            <table>\n" +
                        "                                <tr>\n <td>" +
                             orderItems.describeItemsForEmail(orderItems,email) +
                        str +
                        "                                   </td>\n" +
                        "\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "                        \n" +
                        "                            <table class=\"social\" width=\"100%\">\n" +
                        "                                <tr>\n" +
                        "                                    <td>\n" +
                        "                                        <table align=\"left\" class=\"column\">\n" +
                        "                                            <tr>\n" +
                        "                                                <td>\n" +
                        "                                                    <h5 class=\"\">Connect with Us:</h5>\n" +
                        "                                                    <p class=\"\"><a href=\"#\" class=\"soc-btn fb\">Facebook</a> <a href=\"#\" class=\"soc-btn tw\">Twitter</a> <a href=\"#\" class=\"soc-btn gp\">Google+</a></p>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                        <table align=\"left\" class=\"column\">\n" +
                        "                                            <tr>\n" +
                        "                                                <td>\n" +
                        "                                                    <h5 class=\"\">Contact Info:</h5>\n" +
                        "                                                    <p>Phone: <strong>+48 512 148 921</strong><br />\n" +
                        "                                                        Email: <strong>kovalv97@gmail.com</strong></p>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>\n" +
                        "                                        </table>\n" +
                        "                                        <span class=\"clear\"></span>\n" +
                        "                                    </td>\n" +
                        "                                </tr>\n" +
                        "                            </table>\n" +
                        "                        </td>\n" +
                        "                    </tr>\n" +
                        "                </table>\n" +
                        "            </div>\n" +
                        "        </td>\n" +
                        "        <td></td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "</body>\n" +
                        "</html>\n ";


                String notificationEmail = addTo;

                email.setCharset("UTF-8");
                email.setDataSourceResolver(new DataSourceUrlResolver(new URL("https://localhost:8443")));
                email.setHostName(serviceManager.getApplicationProperty("email.smtp.server"));
                email.setSSLOnConnect(true);
                email.setSslSmtpPort(serviceManager.getApplicationProperty("email.smtp.port"));
                email.setAuthenticator(new DefaultAuthenticator(serviceManager.getApplicationProperty("email.smtp.username"),
                        serviceManager.getApplicationProperty("email.smtp.password")));
                email.setFrom(serviceManager.getApplicationProperty("email.fromEmail"));
                email.setSubject(subject);
                email.setHtmlMsg(htmlEmailTemplate);

                email.addTo(notificationEmail);

                email.send();
            } catch (EmailException e) {
                LOGGER.error("Can't send email: " + e.getMessage(), e);
                tryCount--;
                if (isValidTryCount()) {
                    LOGGER.info("Resend email: {}", this.toString());
                    executorService.submit(this);
                } else {
                    LOGGER.error("Email was not sent: limit of try count");
                }
            } catch (Exception e) {
                LOGGER.error("Error during send email: " + e.getMessage(), e);
            }
        }
    }
}
