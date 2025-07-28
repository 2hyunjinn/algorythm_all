-- 코드를 입력하세요
# 셀 프 웨 그 해 오
SELECT ID, NAME, HOST_ID
from PLACES
where HOST_ID in (
    select HOST_ID
    from PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2
);