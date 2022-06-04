package com.UKHN.server.dto.home;

public class IntroActivityContentFileDto {
    private Long id;

    private Long slideId;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSlideId() {
        return slideId;
    }

    public void setSlideId(Long slideId) {
        this.slideId = slideId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntroActivityContentFileDto{");
        sb.append("id=").append(id);
        sb.append(", slideId=").append(slideId);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}