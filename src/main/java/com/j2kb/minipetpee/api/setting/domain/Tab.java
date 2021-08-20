package com.j2kb.minipetpee.api.setting.domain;

import com.j2kb.minipetpee.api.homepee.domain.Homepee;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Tab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ColumnDefault("1")
    private boolean visible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hompee_id", nullable = false)
    private Homepee homepee;

    public void setHomepee(Homepee homepee) {
        this.homepee = homepee;
    }
}
