package com.springboot.applypage.data.entity;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="changeHistory")
public class ChangeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JoinColumn(name="Q_id")
    private Long Q_id;

    @Column(nullable = false)
    private String change_Q;

    @Column(nullable = false)
    @JoinColumn(name="sid")
    private Long sid;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt; //BaseEntity 상속을 받아야 하나,,

    public ChangeHistory(Long id) {
        this.sid = sid;
        this.updatedAt = LocalDateTime.now();
    }
}
