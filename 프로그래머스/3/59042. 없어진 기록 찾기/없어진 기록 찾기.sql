-- 코드를 입력하세요
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물

SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_OUTS o
    LEFT JOIN ANIMAL_INS i ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE i.ANIMAL_ID is null
ORDER BY o.ANIMAL_ID;