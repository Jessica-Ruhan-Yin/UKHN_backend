package com.UKHN.server.dto.academic;

public class AcademicReportDto {
    private Long id;

    private String date;

    private String text;

    private String form;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AcademicReportDto{");
        sb.append("id=").append(id);
        sb.append(", date='").append(date).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", form='").append(form).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}