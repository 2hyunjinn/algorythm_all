-- 코드를 입력하세요
-- 식품분류별로 가격이 제일 비싼 식품
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
where (category, price) in (
    select category, max(price)
    from FOOD_PRODUCT
    group by category
    having CATEGORY in ('과자', '국', '김치', '식용유')
    )
ORDER BY MAX_PRICE DESC


# SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
# FROM FOOD_PRODUCT
# WHERE (CATEGORY, PRICE) IN (
#                             SELECT CATEGORY, MAX(PRICE)
#                             FROM FOOD_PRODUCT
#                             GROUP BY CATEGORY
#                             HAVING CATEGORY IN ('국', '김치', '식용유', '과자')
# )
# ORDER BY MAX_PRICE DESC
# ;