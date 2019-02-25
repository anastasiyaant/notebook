import java.util.Date;

public class Note {
    private String header;
    private String text;
    private Date date;

    public Note()
    {
        date = null;
        header = "";
        text = "";
    }
    public Note(Date date, String header, String text)
    {
        this.date = date;
        this.header = header;
        this.text = text;
    }

    public void setHeader( String header)
    {
        this.header= header;
    }
    public void setText(String text)
    {
        this.text=text;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public String showHeader()
    {
        String header = this.header;
        return header;
    }
    public String showText()
    {
        String text = this.text;
        return text;
    }
    public Date showDate()
    {
        Date date = this.date;
        return date;
    }
    public void clearNote()
    {
        date = null;
        header = "";
        text = "";
    }
}
