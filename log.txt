Request method:	POST
Request URI:	https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
Proxy:			<none>
Request params:	<none>
Query params:	key=qaclick123
Form params:	<none>
Path params:	<none>
Headers:		Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "location": {
        "lat": -38.383494,
        "lng": 33.427362
    },
    "accuracy": 50,
    "name": "PhaniSwe",
    "phoneNumber": "(+66) 989 111 000",
    "address": "Asok house",
    "types": [
        "shoe park",
        "shop"
    ],
    "website": "https://saiphaniSwetha-academy.com",
    "language": "TH-th"
}
HTTP/1.1 200 OK
Date: Tue, 06 Jun 2023 10:31:08 GMT
Server: Apache/2.4.41 (Ubuntu)
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: POST
Access-Control-Max-Age: 3600
Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
Content-Length: 194
Keep-Alive: timeout=5, max=100
Connection: Keep-Alive
Content-Type: application/json;charset=UTF-8

{
    "status": "OK",
    "place_id": "7220dc669ca64d780bdba9713803c0da",
    "scope": "APP",
    "reference": "aec3b49895109427d301dc456f2d9c0daec3b49895109427d301dc456f2d9c0d",
    "id": "aec3b49895109427d301dc456f2d9c0d"
}
Request method:	GET
Request URI:	https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=7220dc669ca64d780bdba9713803c0da
Proxy:			<none>
Request params:	<none>
Query params:	key=qaclick123
				place_id=7220dc669ca64d780bdba9713803c0da
Form params:	<none>
Path params:	<none>
Headers:		Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
Date: Tue, 06 Jun 2023 10:31:09 GMT
Server: Apache/2.4.41 (Ubuntu)
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: POST
Access-Control-Max-Age: 3600
Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
Content-Length: 230
Keep-Alive: timeout=5, max=100
Connection: Keep-Alive
Content-Type: application/json;charset=UTF-8

{
    "location": {
        "latitude": "-38.383494",
        "longitude": "33.427362"
    },
    "accuracy": "50",
    "name": "PhaniSwe",
    "phone_number": "",
    "address": "Asok house",
    "types": "shoe park,shop",
    "website": "https://saiphaniSwetha-academy.com",
    "language": "TH-th"
}
Request method:	DELETE
Request URI:	https://rahulshettyacademy.com/maps/api/place/delete/json?key=qaclick123
Proxy:			<none>
Request params:	<none>
Query params:	key=qaclick123
Form params:	<none>
Path params:	<none>
Headers:		Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "place_id": "7220dc669ca64d780bdba9713803c0da"
}
HTTP/1.1 200 OK
Date: Tue, 06 Jun 2023 10:31:10 GMT
Server: Apache/2.4.41 (Ubuntu)
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: POST
Access-Control-Max-Age: 3600
Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With
Content-Length: 15
Keep-Alive: timeout=5, max=100
Connection: Keep-Alive
Content-Type: application/json;charset=UTF-8

{
    "status": "OK"
}
