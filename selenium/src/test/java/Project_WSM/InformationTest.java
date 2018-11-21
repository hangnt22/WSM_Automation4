package Project_WSM;

public class InformationTest {

    //Infor of user WSM
    public static final String email = "nguyen.thi.hang@framgia.com.edev";
    public static final String password = "123456";
    public static final String staffName = "Nguyen Thi Hang";
    public static final String staffCode = "B121259";
    public static final String branch = "Handico Office";
    public static final String group[] = {"Software Development Division HIGH/Section 1/Qa1", "Choose Group", "Software Development Division 1", "Software Development Division 3",
            "Design & Marketing Division", "CEO's Office", "Human Development Division", "Back Office", "Founder", "Human Resource"};

    //Infor of data test
    //format data input = {Project_name, Date_from, Date_to,Reason}
    //format data output = {Staff_code, staff_name, date_create, date_from, date_to, project_name, reason, status,handle_by, request_hours}
    public static final String datatest11[] = {"FFL x FVN QONECT APP", "2018/11/27 03:00", "2018/11/27 06:00", "Test11"};
    public static final String ouput11[] = {"B121259", "Nguyen Thi Hang", "11-21-2018", "03:00 11-27-2018", "06:00 11-27-2018", "FFL x FVN QONECT APP", "Test11", "Pending",
            "Section 1(pham viet hoang)", "3.0"};
    public static final String datatest12[] = {"FFL x FVN QONECT APP", "2018/11/27 19:00", "2018/11/27 22:00", "Test12"};
    public static final String ouput12[] = {"B121259", "Nguyen Thi Hang", "11-21-2018", "19:00 11-27-2018", "22:00 11-27-2018", "FFL x FVN QONECT APP", "Test12", "Pending",
            "Section 1(pham viet hoang)", "3.0"};
    public static final String datatest13[] = {"FFL x FVN QONECT APP", "2018/11/25 18:00", "2018/11/25 21:00", "Test13"};
    public static final String ouput13[] = {"B121259", "Nguyen Thi Hang", "11-21-2018", "18:00 11-25-2018", "21:00 11-25-2018", "FFL x FVN QONECT APP", "Test13", "Pending",
            "Section 1(pham viet hoang)", "3.0"};
    public static final String datatest14[] = {"FFL x FVN QONECT APP", "2019/10/25 18:00", "2019/10/25 21:00", "Test14"};
    public static final String ouput14[] = {"B121259", "Nguyen Thi Hang", "11-21-2018", "18:00 10-25-2019", "21:00 10-25-2019", "FFL x FVN QONECT APP", "Test14", "Pending",
            "Section 1(pham viet hoang)", "3.0"};
    public static final String datatest15[] = {"FFL x FVN QONECT APP", "2018/11/24 18:00", "2018/11/24 21:00", "Test15"};
    public static final String datatest16[] = {"FFL x FVN QONECT APP", "2018/11/23 18:00", "2018/11/23 21:00", "Test16"};
    public static final String output16 = "18:00 11-23-2018";
    public static final String datatest17[] = {"FFL x FVN QONECT APP", "2018/11/22 18:00", "2018/11/22 21:00", "Test17"};
    public static final String ouput17[] = {"B121259", "Nguyen Thi Hang", "11-21-2018", "18:00 11-22-2018", "21:00 11-22-2018", "FFL x FVN QONECT APP", "Test17", "Pending",
            "Section 1(pham viet hoang)", "3.0"};
    public static final String datatest18[] = {"FFL x FVN QONECT APP", "2018/07/03 18:00", "2018/07/03 21:00", "Test18"};
    public static final String msgOutput18 = "Timekeeping data of 7/2018 is not available, you can not access for this month!";
    public static final String datatest19[] = {"", "2018/11/22 18:00", "2018/11/22 21:00", "Test19"};
    public static final String msgOutput19 = "Project can not be blank.";
    public static final String datatest20[] = {"FFL x FVN QONECT APP", "", "2018/11/22 21:00", "Test20"};
    public static final String msgOutput20 = "From time not be blank";
    public static final String datatest21[] = {"FFL x FVN QONECT APP", "2018/11/22 18:00", "", "Test21"};
    public static final String msgOutput21 = "End time not be blank";
    public static final String datatest22[] = {"FFL x FVN QONECT APP", "2018/11/22 18:00", "2018/11/22 21:00", ""};
    public static final String msgOutput22 = "Reason not be blank";
    public static final String datatest23[] = {"FFL x FVN QONECT APP", "2018/11/15 18:00", "2018/11/15 21:00", "Test23"};
    public static final String msgOutput23 = "Request has been taken with other request";
    public static final String datatest24[] = {"FFL x FVN QONECT APP", "2018/11/15 08:00", "2018/11/15 03:00", "Test24"};
    public static final String msgOutput24 = "Time request ot invalid: it is not in time period request ot.";
    public static final String datatest25[] = {"FFL x FVN QONECT APP", "2018/11/15 08:00", "2018/11/15 03:00", "Test25"};
    public static final String datatest26[] = {"FFL x FVN QONECT APP", "2018/11/15 08:00", "2018/11/15 03:00", "Test26"};

}
