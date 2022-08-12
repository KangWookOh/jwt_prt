package com.cranesch.cranewebbackend.entity.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum UserRole {
    ADMIN,//(사이트 관리자)
    PRESIDENT,//(회장)
    VICEPRESIDENT,//(부회장)
    SECRETARY,//(총무)
    USER,//(일반 사용자)
    OBSERVER//(졸업 및 휴학, 이메일 인증 이전 사용자)
    ;




}
