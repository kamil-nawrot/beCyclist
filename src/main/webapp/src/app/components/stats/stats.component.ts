import {Component, OnInit} from '@angular/core';
import {StatsService} from "../../services/stats.service";
import IStats from "../../models/stats";

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  statsResults: IStats;
  keys = Object.keys;

  constructor(private statsService: StatsService) {
  }

  ngOnInit(): void {
    this.statsService.getStats().subscribe(response => {
      this.statsResults = response;
      console.log(response);
      for(let field in this.statsResults.fields) {
        this.statsResults.fields[field] = (Math.round(this.statsResults.fields[field] * 10000) * 100) / 10000;
      }
    })
  }



}
