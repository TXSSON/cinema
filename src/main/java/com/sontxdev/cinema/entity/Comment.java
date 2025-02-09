package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.CommentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "casts")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "parent_comment_id")
    private String parentCommentId;
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "status")
    private CommentStatus status;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @ManyToOne
    @JoinColumn(
            name = "video_id",
            nullable = false
    )
    private Video video;
    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
