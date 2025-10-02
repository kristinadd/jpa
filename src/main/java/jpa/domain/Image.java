package jpa.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Image {
  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String filename;

  private int width;
  private int height;

  // Removed @ElementCollection - not allowed inside @Embeddable used in @ElementCollection
  // private Set<String> tags = new HashSet<>();

  public Image() {}

  public Image(String title, String filename, int width, int height) {
    this.title = title;
    this.filename = filename;
    this.width = width;
    this.height = height;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }
  public int getWidth() {
    return width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Image [title=" + title + ", filename=" + filename + ", width=" + width + ", height=" + height + "]";
  }

  //  default is == checks 
  @Override
  public boolean equals(Object object) {
    if (this == object) return true; // point ot the same memory location, same address, so then they are equal
    if (object == null || object.getClass() != this.getClass()) return false;

      Image image = (Image) object;

      if (!this.title.equals(image.title)
      || !this.filename.equals(image.filename)
      || this.width != image.width
      || this.height != image.height) return false;

      return true;
  }

  // representation of the value of this object; this is a key to find an object
  @Override
  public int hashCode() {
    return Objects.hash(title, filename, width, height);
  }

  // @Override
  // public int hashCode() {

  // }
}
