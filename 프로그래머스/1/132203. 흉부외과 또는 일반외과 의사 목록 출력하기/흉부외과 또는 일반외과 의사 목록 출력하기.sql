-- 코드를 입력하세요
# DOCTOR - DR_NAME(의사이름), DR_ID(의사ID), LCNS_NO(면허번호), HIRE_YMD(고용일), MCDP_CD(진료과코드), TLNO(전화번호)
# 진료과가 흉부외과(CS)이거나 일반외과(GS)
# 이름, 의사ID, 진료과, 고용일자를 조회
# 고용일자를 기준으로 내림차순 정렬
# 이름을 기준으로 오름차순 정렬
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;