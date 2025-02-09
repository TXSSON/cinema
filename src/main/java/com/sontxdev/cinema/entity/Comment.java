package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.CommentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "parent_comment_id")
    private String parentCommentId;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "like_count")
    private int likeCount = 0;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CommentStatusEnum status;
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
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
