package models;

import java.util.Date;

public class PerformanceReview {
    private int reviewId;
    private int employeeId;
    private Date reviewDate;
    private int performanceScore;
    private String comments;

    // Constructor
    public PerformanceReview(int reviewId, int employeeId, Date reviewDate, int performanceScore, String comments) {
        this.reviewId = reviewId;
        this.employeeId = employeeId;
        this.reviewDate = reviewDate;
        this.performanceScore = performanceScore;
        this.comments = comments;
    }

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
