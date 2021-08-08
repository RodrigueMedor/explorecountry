import { Component, OnInit } from '@angular/core';
import {CountryService} from "../service/country.service";

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {

  similarCountryFound=0;

  listCountry: any[] | undefined;
  iconUrl= 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
  iconUrl2= ''

  constructor(private countryService: CountryService) { }

  ngOnInit(): void {
  }

  displayValue(){
    this.similarCountryFound = 0;

    console.log(this.countryService.countryForm.value)

    this.countryService.getCountryExplore(this.countryService.countryForm.value)
      .subscribe(data =>{
        this.listCountry = (<[]> data);

        this.similarCountryFound = this.listCountry.length;
        this.listCountry.forEach(count => console.log(count.longitude+" / "+count.latitude))
        console.log("API data : "+data);
      },
        error => {
        console.log("Cadet error : "+error);
        })
  }

  mapClicked($event: MouseEvent){

  }

}
