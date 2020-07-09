package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ReqResModel;
import com.example.demo.service.NumberGenService;

@RestController()	
@RequestMapping(value="/api")
public class NumberGenController {
	
	NumberGenService numberGeneratorService;
	public NumberGenController(NumberGenService numberGeneratorService) {
		this.numberGeneratorService = numberGeneratorService;
	}
	

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public ResponseEntity <ReqResModel> getUniqueNumber(@RequestBody ReqResModel reqResModel) {
		numberGeneratorService.generateFile(numberGeneratorService.generateUUID(reqResModel));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reqResModel);
	}
	
	@RequestMapping(value="/{task}", method=RequestMethod.GET)
    public String getUser(@PathVariable String task) {
		ReqResModel listResult = numberGeneratorService.storeList.stream()
												.filter(e->e.getTask().equalsIgnoreCase(task))
												.findFirst()
												.orElse(null);
		return numberGeneratorService.readFile(listResult.getTask());
    }
	
	
	
}
