-- 코드를 입력하세요
# PATIENT
# PT_NO(환자번호), PT_NAME(환자이름), GEND_CD(성별코드), AGE(나이), TLNO(전화번호)
# 12세 이하인 여자환자
# 환자이름, 환자번호, 성별코드, 나이, 전화번호
# 전화번호가 없는 경우, 'NONE'으로 출력
# 나이를 기준으로 내림차순 정렬
# 환자이름을 기준으로 오름차순 정렬

SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;
