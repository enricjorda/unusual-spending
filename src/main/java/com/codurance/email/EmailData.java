package com.codurance.email;

public class EmailData {
    private String subject;
    private String body;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {

        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailData{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailData emailData = (EmailData) o;

        if (subject != null ? !subject.equals(emailData.subject) : emailData.subject != null) return false;
        return body != null ? body.equals(emailData.body) : emailData.body == null;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}
