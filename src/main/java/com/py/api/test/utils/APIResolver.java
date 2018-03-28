package com.py.api.test.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Map;

public class APIResolver {

    public static <T> T doGet(String apiCode, String endPoint, Class<T> responseType,Map<String, Object> parametros) {

        HttpHeaders headers = new HttpHeaders();

        return doGet(apiCode, endPoint, responseType, parametros, headers);
    }

    public static <T> T doGet(String apiCode, String endPoint, Class<T> responseType,Map<String, Object> parametros,HttpHeaders headers) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<T> response = restTemplate.exchange(addParamUrl(url,parametros), HttpMethod.GET, entity, responseType);

        return response.getBody();
    }



    public static String addParamUrl(String url, Map<String, Object> parametros) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(parametros!=null){
            for(Map.Entry<String, Object> p : parametros.entrySet()){
                if((p.getValue()!=null)&&(p.getValue()!=""))
                    builder.queryParam(p.getKey(),p.getValue());
            }
        }


        return builder.build().toUriString();
    }

    public static String addParamUrl(String url, String[] parametros,String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if(parametros!=null){
            for(String param:parametros){
                if((param!=null && param.length()>0))
                    builder.queryParam(key,param);
            }
        }


        return builder.build().toUriString();
    }

    public static <T> T doGet(String apiCode,String endPoint, ParameterizedTypeReference<T> responseType) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);

        return response.getBody();
    }

    public static <T> T doGet(String apiCode,String endPoint, ParameterizedTypeReference<T> responseType,String[] parametros,String key) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<T> response = restTemplate.exchange(addParamUrl(url,parametros,key), HttpMethod.GET, entity, responseType);

        return response.getBody();
    }

    public static <T, E> T doPut(String apiCode, String endPoint, E requestObject, Class<T> responseType) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<E> entity = new HttpEntity<>(requestObject, headers);

        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.PUT, entity, responseType);

        return response.getBody();
    }
    public static <T, E> T doPut(String apiCode, String endPoint, E requestObject, Class<T> responseType, HttpHeaders headers) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<E> entity = new HttpEntity<>(requestObject, headers);

        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.PUT, entity, responseType);

        return response.getBody();
    }

    public static <T> T doDelete(String apiCode, String endPoint, Class<T> responseType) {

        HttpHeaders headers = new HttpHeaders();

        return doDelete(apiCode, endPoint, responseType, headers);
    }

    public static <T> T doDelete(String apiCode, String endPoint, Class<T> responseType,HttpHeaders headers) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, responseType);

        return response.getBody();
    }
    public static <T, E> T doDelete(String apiCode, String endPoint, E requestObject, Class<T> responseType, HttpHeaders headers) {

        RestTemplate restTemplate = new RestTemplate();
        String url = apiCode + endPoint;


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<E> entity = new HttpEntity<>(requestObject, headers);

        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, responseType);

        return response.getBody();
    }
}
