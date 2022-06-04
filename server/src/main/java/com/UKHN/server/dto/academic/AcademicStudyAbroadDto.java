package com.UKHN.server.dto.academic;

public class AcademicStudyAbroadDto {
    private Long id;

    private String image;

    private String text;

    private String category;

    private String form;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AcademicStudyAbroadDto{");
        sb.append("id=").append(id);
        sb.append(", image='").append(image).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", form='").append(form).append('\'');
        sb.append('}');
        return sb.toString();
    }
}