package com.example.hazelcastdemo.web;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@RestController
public class PutGetController {

    @Qualifier("hazelcastInstance")
    @Autowired
    private HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String,String> keyValueMapDb() {
        return hazelcastInstance.getMap("map");
    }

    @PostMapping("/put")
    public String put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        keyValueMapDb().put(key, value);
        return value;
    }

    @GetMapping("/get")
    public String get(@RequestParam(value = "key") String key) {
        String value = keyValueMapDb().get(key);
        return value;
    }

    @GetMapping
    public Map<String, String> getAll() {
        return keyValueMapDb();
    }

}
