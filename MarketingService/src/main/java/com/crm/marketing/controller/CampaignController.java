package com.crm.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.marketing.entities.Campaign;
import com.crm.marketing.service.CampaignService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/marketing")
@CrossOrigin(origins = "http://localhost:4200")
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@PostMapping("/createCampaign")
	public ResponseEntity<String> createCampaign(@RequestBody @Valid Campaign campaign) {
		campaignService.createCampaign(campaign);
		return ResponseEntity.ok("Campaigns created successfully...");
	}
	
	@GetMapping("/getAllCampaigns")
	public ResponseEntity<List<Campaign>> getAllCampaigns() {
		return new ResponseEntity<>(campaignService.getAllCampaigns(), HttpStatus.OK);
	}
	
}
