package com.j2kb.minipetpee.global;

import lombok.Getter;

@Getter
public enum ErrorCode {
    /**
     * 0xxx: 공통
     */
    EMP0000("잘못된 요청입니다"),
    EMP0001("응답 파라미터가 누락되었습니다."),

    /**
     * 1xxx: 회원가입, 로그인 관련 에러
     */
    EMP1000("유효하지 않은 토큰입니다."),
    EMP1001("만료된 토큰입니다."),
    EMP1002("잘못된 서명입니다."),
    EMP1003("지원하지 않는 토큰입니다."),
    EMP1004("회원 아이디가 누락되었습니다."),
    EMP1005("회원 이름이 누락되었습니다."),
    EMP1006("회원 이메일이 누락되었습니다."),
    EMP1007("회원 역할이 누락되었습니다."),
    EMP1008("회원 비밀번호가 누락되었습니다."),
    EMP1009("Authorization 헤더가 누락되었습니다."),
    EMP1010("이미 존재하는 회원 이메일입니다."),
    EMP1011("유효한 이메일 형식이 아닙니다."),
    EMP1012("비밀번호는 최소 8자 이상이어야 합니다."),
    EMP1013("이름은 최소 2자 이상, 최대 35자 이하여야 합니다."),
    EMP1014("존재하지 않는 이메일입니다."),
    EMP1015("올바르지 않은 비밀번호입니다."),
    EMP1016("홈피 아이디가 누락되었습니다"),

    /**
     * 2xxx: 회원 관련 에러
     */
    EMP2001("회원을 찾을 수 없습니다."),
    EMP2002("회원 세부 정보를 찾을 수 없습니다."),

    /**
     * 3xxx: 홈피 관련 에러
     */
    EMP3001("존재하지 않는 홈피입니다."),

    /**
     * 4xxx: 게시판 관련 에러
     */
    EMP4001("게시글을 찾을 수 없습니다."),
    EMP4002("게시글 제목을 입력하세요."),
    EMP4003("게시글 제목은 1자 이상 20자 이하여야 합니다."),
    EMP4004("게시글 내용을 입력하세요."),
    EMP4005("게시글 내용은 1자 이상 500자 이하여야 합니다."),
    EMP4006("비공개 게시판 입니다."),
    EMP4007("사진 아이디가 누락되었습니다."),
    EMP4008("사진이 누락되었습니다."),

    /**
     * 5xxx: 갤러리 관련 에러
     */
    EMP5001("비공개 갤러리 입니다."),
    EMP5002("존재하지 않는 게시글 입니다."),
    EMP5003("제목이 존재하지 않습니다."),
    EMP5004("사진은 1장 이상 올려야 합니다."),
    EMP5005("사진은 5장까지 올릴 수 있습니다."),

    /**
     * 6xxx: 방명록 관련 에러
     */
    EMP6001("방명록 저장에 실패하였습니다."),
    EMP6002("방명록 수정에 실패하였습니다."),
    EMP6003("방명록 삭제에 실패하였습니다."),
    EMP6004("회원 아이디가 누락되었습니다."),
    EMP6005("방명록 내용이 누락되었습니다."),
    EMP6006("방명록은 200자 이하여야 합니다."),
    EMP6007("방명록 탭을 찾을 수 없습니다."),
    EMP6008("비공개 방명록 입니다."),
    EMP6009("방명록 작성자만 수정 가능합니다."),
    EMP6010("방명록 작성자만 삭제 가능합니다."),

    /**
     * 7xxx: 관리 관련 에러
     */
    EMP7001("계정 조회에 실패하였습니다."),
    EMP7002("탭 목록 조회에 실패하였습니다."),
    EMP7003("홈피 조회에 실패하였습니다."),
    EMP7004("탭 조회에 실패하였습니다."),
    EMP7005("탭 공개여부 설정을 찾을 수 없습니다."),
    EMP7006("홈피 제목을 입력하세요."),
    EMP7007("홈피 제목은 20자 이하여야 합니다."),
    EMP7008("이름을 입력하세요."),
    EMP7009("이름은 2자 이상, 10자 이하여야 합니다."),
    EMP7011("이름에 특수문자를 사용할 수 없습니다."),
    EMP7012("종 설명은 30자 이하여야 합니다."),
    EMP7013("성격 설명은 30자 이하여야 합니다."),
    EMP7014("탭 공개여부 변경에 실패하였습니다."),
    EMP7015("이름에는 영문자, 숫자, 한글, 언더바만 사용할 수 있습니다."),
    EMP7016("대문 사진 변경에 실패하였습니다."),
    EMP7017("프로필 정보가 누락되었습니다"),
    EMP7018("홈피 정보가 누락되었습니다"),
    EMP7019("탭 정보가 누락되었습니다."),


    /**
     * 8xxx: 스타/팬 관련 에러
     */
    EMP8001("스타 회원을 찾을 수 없습니다."),
    EMP8002("스타 회원 정보가 올바르지 않습니다."),
    EMP8003("팬 회원을 찾을 수 없습니다."),
    EMP8004("언스타 회원을 찾을 수 없습니다."),
    EMP8005("언스타 회원 정보가 올바르지 않습니다."),
    EMP8006("스타 정보를 찾을 수 없습니다."),
    EMP8007("스타 목록을 찾을 수 없습니다."),
    EMP8008("팬 목록을 찾을 수 없습니다."),
    EMP8009("이미 스타 한 회원입니다."),

    /**
     * 9xxx: 탭 관련 에러
     */
    EMP9001("메뉴를 찾을 수 없습니다."),

    /**
     * 10xxx: 댓글 관련
     */
    EMP10001("댓글 내용이 누락되었습니다."),
    EMP10002("댓글은 200자 이하여야 합니다."),
    EMP10003("존재하지 않는 댓글 입니다."),
    EMP10004("댓글 작성자만 삭제 가능합니다."),

    /**
     * 11xxx: 공생평 관련
     */
    EMP11001("공생평 아이디가 누락되었습니다."),
    EMP11002("작성자 아이디가 누락되었습니다."),
    EMP11003("공생평 내용이 누락되었습니다."),
    EMP11004("공생평은 200자 이하여야 합니다."),
    EMP11005("존재하지 않는 공생평입니다."),
    EMP11006("홈피 주인의 팬만 작성 가능합니다."),
    EMP11007("공생평 작성자만 수정 가능합니다."),
    EMP11008("공생평 작성자만 삭제 가능합니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
